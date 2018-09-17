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
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { ScanForCardPage } from '../scan-for-card/scan-for-card';
import { AngularFirestore } from '@angular/fire/firestore';
import * as $ from "jquery";
var RegistrationPage = /** @class */ (function () {
    function RegistrationPage(db, navCtrl, navParams, alertCtrl) {
        this.db = db;
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
        this.fname = "";
        this.lname = "";
        this.mob = "9890320298";
        this.add1 = "";
        this.add2 = "";
        this.add3 = "";
        this.otp = "783776";
        this.url = "https://smsapi.engineeringtgr.com/send/?Mobile=9890644298&Password=82HNv5X7yi8dcKi&Key=ajayklFOTSHa8rjv6yzbE7K&Message=Your OTP for Kmart is ";
    }
    RegistrationPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad RegistrationPage');
    };
    RegistrationPage.prototype.MyAlert = function (the_title, the_subTitle) {
        var alert = this.alertCtrl.create({
            title: the_title,
            subTitle: the_subTitle,
            buttons: ['close']
        });
        alert.present();
    };
    RegistrationPage.prototype.validity = function () {
        if (/[A-za-z]{1,}$/.test(this.fname)) {
            if (/[A-za-z]{1,}$/.test(this.lname)) {
                if (/^[0-9]{10}$/.test(this.mob)) {
                    if (/.{1}$/.test(this.mob)) {
                        return true;
                    }
                    else {
                        alert("Enter a  proper Address");
                    }
                }
                else {
                    alert("Enter a  proper Mobile number");
                }
            }
            else {
                MyAlert('Last Name Error', "Enter a  proper and Non-Empty Last name");
            }
        }
        else {
            MyAlert('First Name Error', "Enter a  proper and Non-Empty First name");
        }
        return false;
    };
    RegistrationPage.prototype.verifyOTP = function () {
        var _this = this;
        if (this.validity()) {
            this.db.collection('User_details').add({
                'First_name': this.fname,
                'Last_name': this.lname,
                'Mobile': this.mob,
                'Add1': this.add1,
                'Add2': this.add2,
                'Add3': this.add3
            });
            var prompt_1 = this.alertCtrl.create({
                title: 'Verify OTP',
                message: "A six digit OTP has been sent to your mobile.Please enter your OTP",
                inputs: [
                    {
                        name: 'otp',
                        placeholder: 'OTP',
                        type: 'number'
                    },
                ],
                buttons: [
                    {
                        text: 'Cancel',
                        handler: function (data) {
                            console.log('Cancel clicked');
                        }
                    },
                    {
                        text: 'Verify',
                        handler: function (data) {
                            _this.navCtrl.setRoot(ScanForCardPage);
                        }
                    }
                ]
            });
            prompt_1.present();
            this.url = this.url.concat(this.otp.concat(("&To=".concat(this.mob))));
            $.ajax({
                url: this.url,
                method: "POST"
            }).done(function (res) {
                console.log(res);
            }).fail(function (err) {
                //return error message.
            });
        }
    };
    RegistrationPage = __decorate([
        IonicPage(),
        Component({
            selector: 'page-registration',
            templateUrl: 'registration.html',
        }),
        __metadata("design:paramtypes", [AngularFirestore,
            NavController, NavParams, AlertController])
    ], RegistrationPage);
    return RegistrationPage;
}());
export { RegistrationPage };
//# sourceMappingURL=registration.js.map