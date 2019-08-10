angular.module('demo', ['ngMaterial', 'ngMessages'])
.controller('PalindromeController', function($scope, $http,$timeout,$mdDialog) {
   /* $http.get('http://localhost:8083/hello').
        then(function(response) {
            $scope.greeting = response.data;
        });*/
        function uuidv4() {
          return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
            (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
          )
        }
        if (typeof(Storage) !== "undefined") {
                 if(storage.window.localStorage.getItem('user')==null){


                 }
                 else{

                 }
            } else {
            alert("Update your browser, have no storage support ");   // No web storage Support.
        }


        this.infiniteItems = {
                  numLoaded_: 0,
                  toLoad_: 0,

                  // Required.
                  getItemAtIndex: function(index) {
                    if (index > this.numLoaded_) {
                      this.fetchMoreItems_(index);
                      return null;
                    }

                    return index;
                  },

                  // Required.
                  // For infinite scroll behavior, we always return a slightly higher
                  // number than the previously loaded items.
                  getLength: function() {
                    return this.numLoaded_ + 5;
                  },

                  fetchMoreItems_: function(index) {
                    // For demo purposes, we simulate loading more items with a timed
                    // promise. In real code, this function would likely contain an
                    // $http request.

                    if (this.toLoad_ < index) {
                      this.toLoad_ += 20;
                      $timeout(angular.noop, 300).then(angular.bind(this, function() {
                        this.numLoaded_ = this.toLoad_;
                      }));
                    }
                  }
                };
        $scope.findPalindromes = function(ev){
            let data ={number:$scope.user.number,
            palindromeNum:$scope.user.palindromeNum}
            $http.post("http://localhost:8083/palindromes",data).then(response=>{

                $scope.greeting = response.data;
            });
            console.log(data);
        }
        $scope.showPrerenderedDialog = function(ev) {
           $mdDialog.show({
             contentElement: '#myDialog',
             parent: angular.element(document.body),
             targetEvent: ev,
             clickOutsideToClose: true,

           });
           console.log(ev);
         };

});
console.log("all was fine");