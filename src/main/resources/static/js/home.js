/**
 * 
 */
console.log("099");
var home =angular.module('homeApp', ['ngRoute']);


/*Zvar app = angular.module('homeApp', []);
app.controller('myCtrl', function($scope) {
    $scope.firstName= "John";
    $scope.lastName= "Doe";
});*/
function displayDate() {
   // document.getElementById("demo").innerHTML = Date();
 console.log("111");
}


/*home.service( 'storeHome' , function(){
	var uname="";
 this.setName= function(name)
	{ 
		uname=name;
		
		
	};
    this.getName= function()
	{
		return uname;
	};
	
	//var username = name;
    
   //	return username;
});
*/
home.controller( 'homeController', function($scope,homeFac,homeEmail,homeBool,indexService,$http,$window,$location )
{// $scope.v="see";
	
	
	
	
	
	
	 $http.get('getData'/*, {"headers":{"Accept":""}}*/).then(function successCall(response){
			console.log(response.data+"  dd "+response.data.fname);
		  
		// indexService.setData(response.data);
		 homeFac.setData(response.data);
	 console.log(" a "+homeFac.name);
		$scope.usrInfo=indexService.getData();
		// console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name+" "+indexService.getData().id);
		},function errorCall(response){
			console.log("pp");
			$window.location.href="/";
			//$(location).attr('href', '/'); 
		});
	
	
	$scope.rtvData =function()
	  { var usrInfo={};
	  
	   $http.get('getData').then(function successCall(response)
	   {
		console.log(response.data+"  dd");
	  
	 indexService.setData(response.data);
	 homeFac.setData(response.data);
	 homeBool.setData(false);
	console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name+" dt "+indexService.getData().id);
	 console.log(" a "+homeFac.name);
	 $scope.usrInfo=indexService.getData();
	// console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
	},function errorCall(response){
		//console.log("pp");
		$window.location.href="/";
		//$(location).attr('href', '/'); 
	});
	 }
	 
	 
	 
	 $scope.getEmail =function()
	 {
		
		
		$http.get('getMail').then(function successCall(response){
			console.log(response.data.email+"  deeeeed");
		  homeEmail.setData(response.data);
		  homeBool.setData(true);
		// console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
		},function errorCall(response){
			//console.log("pp");
			$window.location.href="/";
			//$(location).attr('href', '/'); 
		});
	 }
	//console.log("hc "+indexService.getName()+" "+indexService.getPassword());
	//indexService.setName("ii");
	//$window.location="#/";
	/*var data={  "email":"","password":indexService.getPassword(),"username" :indexService.getName(),};
	$http.post('checkCred', data).then(function(response){
		//console.log(response.data+" gg "+response.data=="");
		console.log("gg "+response.data)
		if(response.data=="")
		{console.log((response.data=="")+" "+"dt");
			$(location).attr('href', 'http://localhost:8081/#!/SignIn'); 
		}
		//$window.location.href="http://localhost:8081/SignIn.html";
		//if(response.statusCode==400)
	    	//$window.location.href="http://localhost:8081/SignIn.html";
	  //indexService.setData(response.data);
	  //console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
	}, function errorCallback(response) {
	 //   if(response.statusCode==400)
	   // 	$window.location.href="http://localhost:8081/SignIn.html";
		// called asynchronously if an error occurs
	    // or server returns response with an error status.
	  })*/
		
	  
	  /*$http.post('checkCred', data).then(function(response){
			console.log(response.data=="");
			if(response.data=="")
			$(location).attr('href', 'http://localhost:8081/#!/SignIn'); 
			//$window.location.href="http://localhost:8081/SignIn.html";
			//if(response.statusCode==400)
		    	//$window.location.href="http://localhost:8081/SignIn.html";
		  //indexService.setData(response.data);
		  //console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
		});*/
	  //console.log(indexService.getName()+" gnm");
	/*  $http.get('getData').then(function(response){
			console.log(response.data+"  dd");
		  
		 // indexService.setData(response.data);
		  console.log(indexService.getData().fname+" "+indexService.getData().lname+" "+indexService.getData().name);
		})*/
	  
	  
	  

	
	
});

/**
 * 
 */
console.log("09");
//var home =angular.module('homeApp', ['ngRoute']);

home.service('indexService', function(){
	var uname="";
	var pass="";
	var usrData={};//{name:"", fname:"", lname:""};
	this.setName= function(name)
	{ uname=name;
	}
	
	this.getName=function()
	{
		
		return uname;
	}
	this.setPassword=function(pwd)
	{pass=pwd;
		
		
	}
	this.getPassword=function()
	{
		return pass;
	}
	this.setId=function(data)
	{
		usrData.id=data.id;
	}
	this.getId=function()
	{
		return usrData.id;
	}
	
	this.setData=function(data)
	{  //usrData={};
		usrData.name=data.username;
	    usrData.fname=data.fname;
	    usrData.lname=data.lname;
		usrData.id=data.id;
	}
	this.setNull=function()
	{ console.log("null")
		usrData=null;
	}
	this.getData=function()
	{
		console.log(usrData=={});
		return usrData;
	}

})


home.factory('homeFac', function(){
	var facObj={};
	facObj.setData=function(data)
	{
		facObj.name=data.username;
		facObj.fname=data.fname;
		facObj.lname=data.lname;
		facObj.id=data.id;
		facObj.pwd=data.password;
	}
	
	
	facObj.setNull=function()
	{ console.log("nullf")
		facObj=null;
	}
	
	return facObj;
})
home.service('homeBool', function(){
	
 
var eb;
this.setData= function(data)
{
	eb=data;
}

this.getData= function()
{
	return eb;
}

return eb;
});

home.factory('homeEmail', function(){
	var facObj={};

	facObj.setData=function(data)
	{
		facObj.email=data.email;
		facObj.name=data.username;
	
	}
	
	
	facObj.setNull=function()
	{ console.log("nullf")
		facObj=null;
	}
	
	return facObj;
})


		
home.config(function($routeProvider){
	 $routeProvider                                                                
     .when('/viewInfo', {                                            
       templateUrl: "/viewInfo.html",                                               
       controller: 'viewController',  
    /*  resolve:
    	  {
    	    "IsValid": function($window,homeFac)
    	    { console.log("name");
    	    	if(homeFac.name==undefined)
    	    	{
    	    		console.log("rer");
    	    	
    	    	//	$window.location.href="/home";
    	    	
    	    	}
    	    }
    	  
    	  }*/
      })
	  .when('/viewMail',{
		templateUrl: "/viewEmail.html",                                               
		       controller: 'viewMailController',  
		
	  })
      .when('/modify',{
    	templateUrl: "/modify.html",
    	controller: 'modController',
      })

});



