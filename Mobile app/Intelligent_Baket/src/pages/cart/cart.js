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
var CartPage = /** @class */ (function () {
    function CartPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.initializeItems();
    }
    CartPage.prototype.initializeItems = function () {
        this.ItemsInCart = [
            ['water', '2litre', '45'],
            ['onion', '4kg', '200'],
            ['potato', '4kg', '200'],
            ['yadayada', '2kg', '150'],
            ['pista', '5kg', '400'],
            ['guitar', '1-piece', '7500']
        ];
        this.cart = "unbilled";
    };
    CartPage.prototype.removeItems = function (ev) {
        var str = ev.target.id;
        var x = str.split(",");
        console.log(x[0]);
        this.ItemsInCart = this.ItemsInCart.filter(function (item) { return item[0] !== x[0] && item[1] !== x[1] && item[2] !== x[2]; });
    };
    CartPage = __decorate([
        Component({
            selector: 'page-cart',
            templateUrl: 'cart.html',
        }),
        __metadata("design:paramtypes", [NavController, NavParams])
    ], CartPage);
    return CartPage;
}());
export { CartPage };
//# sourceMappingURL=cart.js.map