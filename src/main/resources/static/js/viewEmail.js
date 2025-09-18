angular.module('homeApp').controller('viewMailController', function($scope, indexService,homeBool,homeEmail,homeFac,$http,$window)
{ console.log("viewsss");
	$scope.usrEmail=homeEmail;
	$scope.logOut=function()
		{  indexService.setNull();
		   homeFac.setNull();
		 	 
		   }
	
	});