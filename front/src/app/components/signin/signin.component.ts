import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private router: Router , private loginService:LoginServiceService) { }

  ngOnInit(){
    this.initForm();
  }

  initForm() {
    this.loginForm = new FormGroup({
      email: new FormControl("", [Validators.required]),
      password: new FormControl("", [Validators.required]),
      remember: new FormControl("", [])
    })
  }

  routeToSignUp(){
    this.router.navigate(['/signup']);
  }


  signIn(){
    if(this.loginForm.valid){
      console.log(this.loginForm.value)
      this.loginService.login(this.loginForm.value).subscribe(
        result =>{
          sessionStorage.setItem("token", result.token);
          sessionStorage.getItem("token");
          this.router.navigate(['/products']);
      },
      error =>{
        alert("Incorrect login details");
        console.log(error)
        console.log(this.loginForm.value)
      }
      )
    }
  }

}
