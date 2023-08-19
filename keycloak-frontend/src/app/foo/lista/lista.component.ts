import { Component, OnInit } from '@angular/core';
import { Foo } from 'src/app/models/foo';
import { FooService } from 'src/app/services/foo.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  foos: Foo[] = [];

  isAdmin?: boolean;
  constructor(private fooService: FooService, private loginService: LoginService) { }
  ngOnInit(): void {
    this.LoadFoos();
    this.isAdmin = this.loginService.getIsAdmin();
  }

  LoadFoos(): void {
    this.fooService.list().subscribe(
      data => {
        this.foos = data
      },
      err => console.log(err)
    );
  }

}
