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
        		url : "viewUsers",
        		data : '',
        		success : function(response) {

        			data = response.data;
        			var result = [];
        			for(i=0; i<data.length; i++){
        				
        /*				var actionColumn = '<button class="btn btn-primary btn-xs" \n\
                            onclick="usersWrapper.deleteUser(' + data[i].email + ')" data-title="Delete">\n\
                        <span class="fa-trash-o" data-toggle="tooltip" data-placement="right" title="Delete user"></span>\n\
                    </button>\n\
                    <button class="btn btn-primary btn-xs" onclick="usersWrapper.editUser(' + i + ')" data-title="Edit user"\n\
                    <span class="fa-pencil" data-toggle="tooltip" data-placement="right" title="Edit user"></span>\n\
                    </button>\n\
        			<button class="btn btn-primary btn-xs" onclick="usersWrapper.suspendUser(' + data[i].email + ')" data-title="Suspend user"\n\
        	        <span class="fa-pencil" data-toggle="tooltip" data-placement="right" title="Suspend user"></span>\n\
        	        </button>';*/
        				var actionColumn = '<a href="#" onclick="usersWrapper.editUser(' + i + ')" class="btn-primary" data-toggle="modal" data-target="#userModal">Edit</a>&nbsp;\n\
        					                <a href="#" onclick="usersWrapper.suspendUser(' + i + ')" class="btn-warning">Suspend</a>&nbsp;\n\
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
                            {"sTitle": "Email", "sWidth": "15%"},
                            {"sTitle": "Mobile", "sWidth": "10%"},
                            {"sTitle": "city", "sWidth": "10%"},
                            {"sTitle": "Actions", "sWidth": "10%"}
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
									alertify.success('Network issue. Try after some time.');
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
		suspendUser : function(index) {
			alert('suspend');
		}
	};
})();