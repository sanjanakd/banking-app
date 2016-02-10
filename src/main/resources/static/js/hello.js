angular.module('hello', [])
    .controller('home', function($scope) {
        $scope.greeting = {id: 'yogesh', content: 'Hello World!',address:'old meadow road'}
    })