addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);


function hideURLbar() {
	window.scrollTo(0, 1);
}

$(document).ready(function() {
	//show sign up view on first load
//	showSignup();
});

/*
//toggle sign up - login views
function showSignup() {
	$("#loginDiv").hide();
	$("#signupDiv").show();
	$('h1').text("Sign Up");
}

function showLogin() {
	$("#signupDiv").hide();
	$("#loginDiv").show();
	$('h1').text("Login");
}

function signup() {
	event.preventDefault();
	$.ajax({
		type: "POST",
		url : "signup",
		data : $("#signupForm").serialize(),
		success : function(data) {
			alert(data);
		}
	});
}

//validations
$("#signupForm").validate({

	rules : {
		name : "required",
		email : {
			required : true,
			email : true
		},
		pswd : {
			required : true,
			minlength : 5
		},
		mobile : {
			required : true,
			minlength : 10,
			maxlength : 10,
		},
		city : {
			required : true
		},
		cnfPswd : {
			confirmPassword : true
		}
	},
	// Specify validation error messages
	messages : {
		firstname : "Please enter your firstname",
		lastname : "Please enter your lastname",
		pswd : {
			minlength : "Your password must be at least 5 characters long"
		},
		email : "Please enter a valid email address"
	},

	submitHandler : function(form) {
		signup();
	}
});

$.validator.addMethod("confirmPassword", function(value, element, params) {
	if (value === $("#pswd").val())
		return true;
	else
		return false;
}, "password doesn't match");
*/