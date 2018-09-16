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
        				
        				var statusString;
        				if(data[i].activeFlag === "Y"){
        					statusString = '<a href="#" onclick="usersWrapper.toggleUserStatus(' + i + ')" class="btn-warning">Suspend</a>';
        				} else {
        					statusString = '<a href="#" onclick="usersWrapper.toggleUserStatus(' + i + ')" class="btn-success">Activate</a>';
        				}
        				
        				var actionColumn = '<a href="#" onclick="usersWrapper.editUser(' + i + ')" class="btn-primary" data-toggle="modal" data-target="#userModal">Edit</a>&nbsp;\n\
        					                '+statusString+'&nbsp;\n\
        					                <a href="#" onclick="usersWrapper.deleteUser(' + i + ')" class="btn-danger">Delete</a>';
        				
        				result[i] = new Array(data[i].name, data[i].email, data[i].mobile, data[i].city,actionColumn);
        			}
        			
        			$('#usersTable').dataTable({
                        "destroy": true,
                        "aaData": result,
                        "scrollX": true,
                        "scrollY": 550,
                        "scrollCollapse": true,
                        /*"order": [[1, "asc"]],*/
                        "aoColumns": [
                        	{"sTitle": "name", "sWidth": "10%"},
                            {"sTitle": "Email", "sWidth": "13%"},
                            {"sTitle": "Mobile", "sWidth": "10%"},
                            {"sTitle": "city", "sWidth": "10%"},
                            {"sTitle": "Actions", "sWidth": "12%"}
                        ]
                    });
        		}
        	});
        },
		deleteUser : function(index) {
			alertify.confirm("Deleting " + data[index].name + ". Are you sure?",
					function() {
						$.ajax({
							type : 'post',
							url : 'deleteUser',
							data : {email : data[index].email},
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
		},
		editUser : function(index) {
			$('#userModal').modal('show');
			$('#id').val(data[index].id);
			$('#name').val(data[index].name);
			$('#email').val(data[index].email);
			$('#mobile').val(data[index].mobile);
			$('#city').val(data[index].city);
		},
		updateUser: function() {
			event.preventDefault();
			$.ajax({
				type: 'POST',
				url: 'updateUser',
				data: {id:$('#id').val(),name :$('#name').val(), email:$('#email').val(),
					mobile:$('#mobile').val(),city:$('#city').val()},
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
		toggleUserStatus : function (index) { //suspend or activate user
			alertify.confirm("Are you sure?",
					function() {
						$.ajax({
							type: 'POST',
							url: 'toggleUserStatus',
							data: {id:data[index].id, activeFlag:data[index].activeFlag},
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
		}
	};
})();