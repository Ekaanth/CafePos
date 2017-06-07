import { Component, OnInit } from '@angular/core';
import { ServeService } from '../serve/serve.service';
@Component({
  selector: 'app-serve-list',
  templateUrl: './serve-list.component.html',
  styleUrls: ['./serve-list.component.css'],
  providers:[ServeService]
})
export class ServeListComponent implements OnInit {

getDatetime = new Date();

serves: Array<any>;
  constructor(private serveService: ServeService) { 

  }

  ngOnInit() {
    this.serveService.getAll().subscribe(
      data => {
        this.serves = data;
      },
      error => console.error(error)

    );
  }

}
