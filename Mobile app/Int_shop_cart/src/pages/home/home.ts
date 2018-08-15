import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { BarcodeScanner ,BarcodeScannerOptions} from '@ionic-native/barcode-scanner';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
	options: BarcodeScannerOptions;
	encodeText:string = '';
	encodeData:any = [];
	scanData:any = [];

  
  constructor(public navCtrl: NavController,public scanner:BarcodeScanner) {

  }

	scan()
	{
		this.options = {
			prompt : 'Scan your Qrcode'
		};
		this.scanner.scan(this.options).then((data) => {
			this.scanData = data;
		},
		(err) =>{
			console.log('Error : ',err);
		})
	}

}
