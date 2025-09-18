angular.module('homeApp').controller('modController' ,function($scope, indexService, homeFac,$http,$window)
{console.log("mod");
	$scope.test="testing";
 console.log(homeFac.id);
	$scope.update=function()
	{	var usr={};  
	   usr.id=homeFac.id;	
	  usr.fname=homeFac.fname;
	  usr.lname=homeFac.lname;
		//usr.lname=$scope.lname;
	  if($scope.nusr)
		usr.username=$scope.nname;
	else
	  usr.username=homeFac.name;

	  
	  if($scope.npwd)
	  	usr.password=$scope.npass;
	  else
	    usr.password=homeFac.pwd;
	console.log("up "+usr.password);
	   // usr.password=$scope.npass;
		//console.log(usr.id+" "+$scope.uname+" "+$scope.lname+" "+$scope.fname);
		$http.post('modifyInfo',usr).then(function successCall(response)
		{
		  console.log(response.data);
		//$window.location.href="/home";
		
	  },function errorCall(errorResp){
		
	 });
	
	}
	$scope.goHome=function()
	{
		
		$window.location.href="/home";
		
	}
});