import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ProfilePage } from '../pages/profile/profile'
import { CartPage } from '../pages/cart/cart'
import { ListPage } from '../pages/list/list';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { WelcomePage } from '../pages/welcome/welcome'
import { RegistrationPage } from '../pages/registration/registration';
import { ScanForCardPage } from '../pages/scan-for-card/scan-for-card';
import { MapPage } from '../pages/map/map';
import { BillsPage } from '../pages/bills/bills';
import { BarcodeScanner } from '@ionic-native/barcode-scanner';
import { AngularFireModule } from '@angular/fire';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { IonicStorageModule } from '@ionic/storage';


 var config = {
    apiKey: "AIzaSyB3XMaD98uIQ5G8-XToXlQkZ8oDFoV2RPc",
    authDomain: "the-smart-basket.firebaseapp.com",
    databaseURL: "https://the-smart-basket.firebaseio.com",
    projectId: "the-smart-basket",
    storageBucket: "the-smart-basket.appspot.com",
    messagingSenderId: "860894275860"
  };

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    ListPage,
    ProfilePage,
    CartPage,
    WelcomePage,
    RegistrationPage,
    ScanForCardPage,
    MapPage,
    BillsPage

  ],
 
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(config),
    AngularFirestoreModule,
    AngularFireStorageModule,
    IonicStorageModule.forRoot({
      name: '__mydb',
         driverOrder: ['indexeddb', 'sqlite', 'websql']
    })
     

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
    ScanForCardPage,
    MapPage,
    BillsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    BarcodeScanner,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
  ]
})
export class AppModule {}
