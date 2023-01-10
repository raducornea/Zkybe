import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { MatButtonModule, MatCardModule, MatToolbarModule } from '@angular/material';
import { ChatInformationComponent } from './chat/chat-information/chat-information.component';
import { ChatConversationComponent } from './chat/chat-conversation/chat-conversation.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { ChatButtonComponent } from './chat/chat-button/chat-button.component';
import { ChatMessagesComponent } from './chat-messages/chat-messages.component';


@NgModule({
  // de pus componentele aici
  declarations: [
    AppComponent,
    LandingpageComponent,
    ChatInformationComponent,
    ChatConversationComponent,
    RegisterComponent,
    HeaderComponent,
    ChatButtonComponent,
    ChatMessagesComponent
  ],
  // de pus modulele aici
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
