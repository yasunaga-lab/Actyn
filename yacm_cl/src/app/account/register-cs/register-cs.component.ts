import {Component, OnInit} from '@angular/core';
import {AccountService} from "../account.service";
import {FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
  selector: 'app-register-cs',
  templateUrl: './register-cs.component.html',
  styleUrls: ['./register-cs.component.css']
})
export class RegisterCsComponent implements OnInit {
  ldap: LdapInfo = new LdapInfo();
  infoInvalid: boolean = false;
  hide: boolean = true;

  constructor(private accountService: AccountService, private router: Router) {
  }

  ngOnInit(): void {
  }

  debug() {
    console.log(this.ldap);
    console.log(JSON.stringify(this.ldap));
  }

  async register() {
    this.infoInvalid = this.ldap.invalidLdapForms();
    if (this.infoInvalid) return
    await this.accountService.registerCS(this.ldap.jsonify());
    await this.router.navigateByUrl('/account/register-result');
  }
}

class LdapInfo {

  lastName = new FormControl('', [Validators.required, Validators.pattern(/^[A-Z]+$/)]);
  firstName = new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]);
  accountName = new FormControl('', [Validators.required, Validators.pattern(/^[0-9a-zA-Z]+$/)]);
  password = new FormControl('', [Validators.pattern(/^(?=.*?[a-zA-Z])(?=.*?\d)[a-zA-Z\d]{8,}$/)]);

  invalidLdapForms(): boolean {
    return this.lastName.invalid || this.firstName.invalid || this.accountName.invalid || this.password.invalid
  }

  get lastNameError() {
    if (this.lastName.hasError('required')) {
      return '入力してください';
    }
    return this.lastName.hasError('pattern') ? '全て大文字英字で入力してください' : '';
  }

  get firstNameError() {
    if (this.firstName.hasError('required')) {
      return '入力してください';
    }
    return this.firstName.hasError('pattern') ? '全て英字で入力してください' : '';
  }

  get accountNameError() {

    if (this.accountName.hasError('required')) {
      return '入力してください';
    }
    return this.accountName.hasError('pattern') ? '全て英数字で入力してください' : '';
  }

  get passwordError() {
    if (this.password.hasError('required')) {
      return '入力してください';
    }
    return this.password.hasError('pattern') ? '英数字・記号を含む8文字以上' : '';
  }

  jsonify() {
    return JSON.stringify(new LdapModel(this.lastName.value!, this.firstName.value!, this.accountName.value!, this.password.value!));
  }

}

class LdapModel {
  lastName: string;
  firstName: string;
  accountName: string;
  password: string;

  constructor(lastName: string, firstName: string, accountName: string, password: string) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.accountName = accountName;
    this.password = password;
  }
}
