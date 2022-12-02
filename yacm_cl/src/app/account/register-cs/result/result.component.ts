import {Component, OnInit} from '@angular/core';
import {AccountService} from "../../account.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  isError: boolean = false;
  result: Object | HttpErrorResponse;

  isSuccess?: boolean;
  status?: bigint;
  message?: string;

  constructor(accountService: AccountService) {
    this.result = accountService.registrationResult!;
    if (accountService.registrationResult instanceof HttpErrorResponse) {
      this.isError = true;
    } else {
      let registrationResult = this.result as CsRegistrationResult
      this.isSuccess = registrationResult.isSuccess
      this.message = registrationResult.message
      console.log(this.result)
    }

  }

  ngOnInit(): void {
  }
}

type CsRegistrationResult = {
  isSuccess: boolean;
  message: string;
}
