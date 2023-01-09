import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from '../objects/User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input() user: User | null = null;

  @Output() onLoginClicked: EventEmitter<void> = new EventEmitter<void>();
  @Output() onLogoutClicked: EventEmitter<void> = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  onLogin() {
    this.onLoginClicked.emit();
  }
  onLogout() {
      this.onLogoutClicked.emit();
  }

}
