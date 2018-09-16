$(function() {
	usersWrapper.getAllUsers();
});

var usersWrapper = (function() {
	var data;
	
	return {
        getData: function (){
            return data;
        },
        setData: function (list){
            data = list;
        },
        
        getAllUsers: function () {
        	$.ajax({
        		type : 'GET',
        		url : "getAllUsers",
        		data : '',
        		success : function(response) {

        			data = response.data;
        			var result = [];
        			for(i=0; i<data.length; i++){
        				var radioColumn = '<input type="radio" name="selection" value="'+ i +'">';
        				var status;
        				if(data[i].activeFlag == false){
        					status = 'Active';
        				} else {
        					status = 'Suspended';
        				}
        				result[i] = new Array(radioColumn, data[i].name, data[i].email, data[i].mobile, data[i].city, status);
        			}
        			
        			$('#usersTable').dataTable({
                        "destroy": true,
                        "aaData": result,
                        "scrollX": true,
                        "scrollY": 550,
                        "scrollCollapse": true,
                        /*"order": [[1, "asc"]],*/
                        "aoColumns": [
                        	{"sTitle": "Select", "sWidth": "2%"},
                        	{"sTitle": "Name", "sWidth": "10%"},
                            {"sTitle": "Email", "sWidth": "13%"},
                            {"sTitle": "Mobile", "sWidth": "10%"},
                            {"sTitle": "City", "sWidth": "10%"},
                            {"sTitle": "Status", "sWidth": "10%"}
                        ]
                    });
        		}
        	});
        },
		deleteUser : function() {
			var index = $('input[name=selection]:checked').val();
			if(index != undefined) {
			alertify.confirm("Deleting " + data[index].name + ". Are you sure?",
					function() {
						$.ajax({
							type : 'post',
							url : 'deleteUser',
							data : {email : data[index].email, _csrf : $('#csrf').val()},
							success : function(data, textStatus, request) {
								usersWrapper.getAllUsers();
								if (data === 'deleted') {
									alertify.success('Deleted!');
								} else {
									alertify.error('Network issue. Try after some time.');
								}
							}
						});
					}, 
					function() {
						// on cancel logic
					});
			} else {
				alertify.warning('Please select a record');
			}
		},
		editUser : function() {
			var index = $('input[name=selection]:checked').val();
			if(index != undefined) {
			$('#userModal').modal('show');
			$('#id').val(data[index].id);
			$('#name').val(data[index].name);
			$('#email').val(data[index].email);
			$('#mobile').val(data[index].mobile);
			$('#city').val(data[index].city);
			} else {
				alertify.warning('Please select a record');
			}
		},
		updateUser: function() {
			event.preventDefault();
			$.ajax({
				type: 'POST',
				url: 'updateUser',
				data: {id:$('#id').val(),name :$('#name').val(), email:$('#email').val(),
					mobile:$('#mobile').val(),city:$('#city').val(), _csrf : $('#csrf').val()},
				success: function(data) {
						if(data == 'updated'){
							usersWrapper.getAllUsers();
							$('#userModal').modal('hide');
							alertify.success("Updated");
						} else {
							alertify.error("Network issue. Try after some time.");
						}
				}
			});
		},
		toggleUserStatus : function () { //suspend or activate user
			var index = $('input[name=selection]:checked').val();
			if(index != undefined) {
			alertify.confirm("Are you sure?",
					function() {
						$.ajax({
							type: 'POST',
							url: 'toggleUserStatus',
							data: {id : data[index].id, activeFlag : data[index].activeFlag, _csrf : $('#csrf').val()},
							success: function (data) {
								if(data === 'success'){
									usersWrapper.getAllUsers();
									alertify.success("Updated user status");
								} else {
									alertify.error("Issue occured. try again.");
								}
							}
						});
					},
					function() {
						// on cancel logic
					});
			} else {
				alertify.warning('Please select a record');
			}
		}
	};
})();