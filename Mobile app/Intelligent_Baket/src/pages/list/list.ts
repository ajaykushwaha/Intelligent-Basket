import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';


@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
 
  searchQuery: string = '';
  items: string[];
  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.initializeItems();
   
  }

  initializeItems() 
  {
    this.items = [
      'Amsterdam',
      'Bogota'
    ];
  }

  getItems(ev: any) 
  {
    // Reset items back to all of the items
    console.log(ev)
    this.initializeItems();

    // set val to the value of the searchbar
    const val = ev.target.value;
    if (val && val.trim() != '') 
    {
      this.items = this.items.filter((item) => {
        return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
      })
    }
  }

  // logEvent(ev: any) {
  //   console.log("Shit happend");
  //   var closebtns = document.getElementsByClassName(ev.target.id);
  //   var i;
  //   for (i = 0; i < closebtns.length; i++) {
  //     closebtns[i].parentElement.style.display = 'none';
  //   };
  //   }

  logEvent(ev: any) {
    var closebtns = document.getElementById(ev.target.id);
    closebtns.parentElement.style.display = 'none';
    }  
}
