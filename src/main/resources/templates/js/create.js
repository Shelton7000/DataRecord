/**
 * 
 */
var create= angular.module('createApp',["ngRoute"]);
create.controller('createController',function($scope)
{ //$scope.name
	console.log("dd");
	//console.log($scope.name+" "+$scope.pwd+" "+$scope.email);
	 
	
	$scope.sendData= function()
	  { //console.log("abbb");
	 // $http.get("/Records/info"/*,{headers:{ 'Accept': 'application/json'}}*/ ).then(function(response){
		//console.log(response.data);
		  console.log($scope.name+" "+$scope.pwd+" "+$scope.email);
	 
	       
	  //$scope.valid=infoValid();
	  }})
	  
	  
	  create.config(function($routeProvider) {
    $routeProvider
    .when("/checked", {
        templateUrl : "validIn.html",
        	controller : "createController"
    })/*. 
    otherwise("/"{
    */   
    
});

create.directive('infoValid', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attr, mCtrl) {
            function myValidation(value) {
                if (value.length > 5) {
                    mCtrl.$setValidity('charE', true);
                } else {
                    mCtrl.$setValidity('charE', false);
                }
                return value;
            }
            mCtrl.$parsers.push(myValidation);
        }
    };
});