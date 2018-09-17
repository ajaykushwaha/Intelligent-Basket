var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ProfilePage } from '../pages/profile/profile';
import { CartPage } from '../pages/cart/cart';
import { ListPage } from '../pages/list/list';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { WelcomePage } from '../pages/welcome/welcome';
import { RegistrationPage } from '../pages/registration/registration';
import { ScanForCardPage } from '../pages/scan-for-card/scan-for-card';
import { BarcodeScanner } from '@ionic-native/barcode-scanner';
import { AngularFireModule } from '@angular/fire';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFirestoreModule } from '@angular/fire/firestore';
var config = {
    apiKey: "AIzaSyB3XMaD98uIQ5G8-XToXlQkZ8oDFoV2RPc",
    authDomain: "the-smart-basket.firebaseapp.com",
    databaseURL: "https://the-smart-basket.firebaseio.com",
    projectId: "the-smart-basket",
    storageBucket: "the-smart-basket.appspot.com",
    messagingSenderId: "860894275860"
};
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        NgModule({
            declarations: [
                MyApp,
                HomePage,
                ListPage,
                ProfilePage,
                CartPage,
                WelcomePage,
                RegistrationPage,
                ScanForCardPage
            ],
            imports: [
                BrowserModule,
                IonicModule.forRoot(MyApp),
                AngularFireModule.initializeApp(config),
                AngularFirestoreModule,
                AngularFireStorageModule
            ],
            bootstrap: [IonicApp],
            entryComponents: [
                MyApp,
                HomePage,
                ListPage,
                ProfilePage,
                CartPage,
                WelcomePage,
                RegistrationPage,
                ScanForCardPage
            ],
            providers: [
                StatusBar,
                SplashScreen,
                BarcodeScanner,
                { provide: ErrorHandler, useClass: IonicErrorHandler }
            ]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
//# sourceMappingURL=app.module.js.map