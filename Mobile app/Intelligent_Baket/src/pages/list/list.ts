import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';


@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
 
  searchQuery: string = '';
  ItemsNotInList: string[];
  ItemsInList: string[];
  ItemsListTemp: string[];
  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.initializeItems();
   
  }


  initializeItems() 
  {
    this.ItemsNotInList = [
      'Amsterdam',
      'Bogota',
      'cata',
      'data',
      'maggie',
      'water'
    ];
    this.ItemsInList = [];
    this.ItemsListTemp = Object.assign([],this.ItemsNotInList);
  }

  getItems(ev: any) 
  {

    // set val to the value of the searchbar
    this.ItemsListTemp = Object.assign([],this.ItemsNotInList);
    const val = ev.target.value;
    if (val && val.trim() != '') 
    {
      this.ItemsListTemp = this.ItemsListTemp.filter((item) => {
        return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
      })
    }

  }

  addItems(ev: any)
  {
    //console.log(ev.target.textContent);
    this.ItemsNotInList = this.ItemsNotInList.filter(item => item !== ev.target.textContent);
    this.ItemsListTemp = this.ItemsListTemp.filter(item => item !== ev.target.textContent);
    this.ItemsInList.push(ev.target.textContent);
    this.ItemsInList.sort();
    this.ItemsListTemp.sort();
    //console.log(this.ItemsInList);
  }
  // logEvent(ev: any) {
  //   console.log("Shit happend");
  //   var closebtns = document.getElementsByClassName(ev.target.id);
  //   var i;
  //   for (i = 0; i < closebtns.length; i++) {
  //     closebtns[i].parentElement.style.display = 'none';
  //   };
  //   }

  removeItems(ev: any) {
     var closebtns = document.getElementById(ev.target.id);
    // closebtns.parentElement.style.display = 'none';

     var str = closebtns.parentElement.textContent;
     str = str.substring(0,str.length - 1);
     //console.log(str);
    this.ItemsInList = this.ItemsInList.filter(item => item !== str);
    this.ItemsNotInList.push(str);
    this.ItemsListTemp = Object.assign([],this.ItemsNotInList);
    this.ItemsNotInList.sort();
    this.ItemsListTemp.sort();
    }  
}
