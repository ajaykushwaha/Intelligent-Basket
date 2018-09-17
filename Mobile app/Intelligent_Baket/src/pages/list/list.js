var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
var ListPage = /** @class */ (function () {
    function ListPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.searchQuery = '';
        this.initializeItems();
    }
    ListPage.prototype.initializeItems = function () {
        this.ItemsNotInList = [
            'Amsterdam',
            'Bogota',
            'cata',
            'data',
            'maggie',
            'water'
        ];
        this.ItemsInList = [];
        this.ItemsListTemp = Object.assign([], this.ItemsNotInList);
    };
    ListPage.prototype.getItems = function (ev) {
        // set val to the value of the searchbar
        this.ItemsListTemp = Object.assign([], this.ItemsNotInList);
        var val = ev.target.value;
        if (val && val.trim() != '') {
            this.ItemsListTemp = this.ItemsListTemp.filter(function (item) {
                return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
            });
        }
    };
    ListPage.prototype.addItems = function (ev) {
        //console.log(ev.target.textContent);
        this.ItemsNotInList = this.ItemsNotInList.filter(function (item) { return item !== ev.target.textContent; });
        this.ItemsListTemp = this.ItemsListTemp.filter(function (item) { return item !== ev.target.textContent; });
        this.ItemsInList.push(ev.target.textContent);
        this.ItemsInList.sort();
        this.ItemsListTemp.sort();
        //console.log(this.ItemsInList);
    };
    // logEvent(ev: any) {
    //   console.log("Shit happend");
    //   var closebtns = document.getElementsByClassName(ev.target.id);
    //   var i;
    //   for (i = 0; i < closebtns.length; i++) {
    //     closebtns[i].parentElement.style.display = 'none';
    //   };
    //   }
    ListPage.prototype.removeItems = function (ev) {
        var closebtns = document.getElementById(ev.target.id);
        // closebtns.parentElement.style.display = 'none';
        var str = closebtns.parentElement.textContent;
        str = str.substring(0, str.length - 1);
        //console.log(str);
        this.ItemsInList = this.ItemsInList.filter(function (item) { return item !== str; });
        this.ItemsNotInList.push(str);
        this.ItemsListTemp = Object.assign([], this.ItemsNotInList);
        this.ItemsNotInList.sort();
        this.ItemsListTemp.sort();
    };
    ListPage = __decorate([
        Component({
            selector: 'page-list',
            templateUrl: 'list.html'
        }),
        __metadata("design:paramtypes", [NavController, NavParams])
    ], ListPage);
    return ListPage;
}());
export { ListPage };
//# sourceMappingURL=list.js.map