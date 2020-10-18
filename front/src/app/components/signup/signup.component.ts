import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignUpService } from 'src/app/services/merchants/sign-up.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;

  constructor(private router: Router, private signUpService: SignUpService) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.signUpForm = new FormGroup({
      email: new FormControl("", [Validators.required]),
      password: new FormControl("", [Validators.required]),
      merchant_type: new FormControl("", [Validators.required]),
      merchant_name: new FormControl("", [Validators.required]),
      owner_name: new FormControl("", [Validators.required]),
      address: new FormControl("", [Validators.required]),
      phone: new FormControl("", [Validators.required]),
    })
  }

  routeToSignIn(){
    this.router.navigate(['/signin']);
  }

  signUp(){
    if(this.signUpForm.valid){
      this.signUpService.signUp(this.signUpForm.value).subscribe(
        result =>{
          this.router.navigate(['/signin']);
      });
    }
}
}
