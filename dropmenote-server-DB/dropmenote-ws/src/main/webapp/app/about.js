app.controller("AboutController", function ($rootScope, $scope, $cookies, $location, $http, dpnDialog, dpnService) {
    $scope.$on('$routeChangeSuccess', function (event) {
        gtag('config', 'G-HW2X468HDZ', {
            'page_title': 'About',
            'page_path': $location.url()
        });
    });
});
