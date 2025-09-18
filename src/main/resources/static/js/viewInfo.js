
angular.module('homeApp').controller('viewController', function($scope, indexService,homeBool,homeEmail,homeFac,$http,$window)
{ console.log("viewsss");
	$scope.usrInfo=homeFac;
	//$scope.usrEmail=homeEmail;
	//$scope.switch= function(){
	//$scope.ebool=homeBool.getData();
	//}
	console.log("eeb "+$scope.ebool);
/*console.log($scope.usrInfo+" tx "+indexService.getData().name);
if($scope.usrInfo.name==undefined)
	{ console.log("not");
		$window.location.href="";
	//$(location).attr('href', 'http://localhost:8081/'); 
	//$window.location="#/";
 }*/
	
console.log("fn "+homeFac.fname);
 console.log($scope.usrInfo.name);
//if($scope.usrInfo.name==undefined)
	//$window.location.href="/";
/*
	$scope.goHome=function()
	{
	 $window.location="#/";
	}*/
	$scope.logOut=function()
	{  indexService.setNull();
	   homeFac.setNull();
	 	 
	   
		/*$http.get('logout').then(function(response){
		console.log(response.data+"  dd");
		  
		 // indexService.setData(response.data);
		  //console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
		}, function errorCallback(response) {
			console.log("er"); 
			//   if(response.statusCode==400)
			   // 	$window.location.href="http://localhost:8081/SignIn.html";
				// called asynchronously if an error occurs
			    // or server returns response with an error status.
			 indexService.setNull();
		})
			 // console.log("pr")
			 // indexService.setNull();
	
	 $window.location.href="http://localhost:8081/";
	//$location.replace();*/
	}
	
});
/*function viewController($scope)
{
 console.log("viewt");	
}*/