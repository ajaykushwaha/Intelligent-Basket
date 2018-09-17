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
import { IonicPage, NavController } from 'ionic-angular';
import { BarcodeScanner } from '@ionic-native/barcode-scanner';
var ScanForCardPage = /** @class */ (function () {
    function ScanForCardPage(navCtrl, scanner) {
        this.navCtrl = navCtrl;
        this.scanner = scanner;
        this.encodeText = '';
        this.encodeData = [];
        this.scanData = [];
    }
    ScanForCardPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ScanForCardPage');
    };
    ScanForCardPage.prototype.scan = function () {
        var _this = this;
        this.options = {
            prompt: 'Scan your Qrcode'
        };
        this.scanner.scan(this.options).then(function (data) {
            _this.scanData = data;
        }, function (err) {
            console.log('Error : ', err);
        });
    };
    ScanForCardPage = __decorate([
        IonicPage(),
        Component({
            selector: 'page-scan-for-card',
            templateUrl: 'scan-for-card.html',
        }),
        __metadata("design:paramtypes", [NavController, BarcodeScanner])
    ], ScanForCardPage);
    return ScanForCardPage;
}());
export { ScanForCardPage };
//# sourceMappingURL=scan-for-card.js.map