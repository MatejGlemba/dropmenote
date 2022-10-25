app.controller("SidebarController", function($rootScope, $scope, $location, $cookies, $http, dpnDialog, dpnService) {

     $scope.userAlias = localStorage.getItem("dpn_userAlias") ? localStorage.getItem("dpn_userAlias") : "";
     $scope.userLogin = localStorage.getItem("dpn_userLogin") ? localStorage.getItem("dpn_userLogin") : "";
     $scope.userIcon = localStorage.getItem("dpn_userIcon") ? localStorage.getItem("dpn_userIcon") : "";

     $scope.click_showLoginDialog = function () {
          // TODO toto je len example ako to volat spravne
          dpnDialog.showLogin();
     }

     $scope.click_showForgotPasswordDialog = function () {
          // TODO toto je len example ako to volat spravne
          dpnDialog.showForgotPassword();
     }

     $scope.logout = function() {
          //callbacks
          var call_user_logout_callBackSuccess = function (data) {
               dpnDialog.showLogin();
          }
          var call_user_logout_callBackError = function (data) {
               dpnService.processErrorResponse(data);
          }
          dpnService.call_user_logout(call_user_logout_callBackSuccess, call_user_logout_callBackError);
     }
     
     $scope.isActive = function (viewLocation) { 
          return viewLocation === $location.path();
     };

     // watchers on email and alias values
     $scope.$on('login.email.value', function (event, value) {
          if (value) {
               $scope.userLogin = value;
          }
     });

     $scope.$on('login.alias.value', function (event, value) {
          // alias can be null
          $scope.userAlias = value;
     });

     $scope.$on('login.icon.value', function (event, value) {
          if (value) {
               $scope.userIcon = value;
          }
     });
});
