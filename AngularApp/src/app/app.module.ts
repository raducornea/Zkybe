import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
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
import { UserProfileComponent } from './user-profile/user-profile.component';
import { environment } from 'src/environments/environment';
import { AuthModule, LogLevel } from 'angular-auth-oidc-client';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';

@NgModule({
  // de pus componentele aici
  declarations: [
    AppComponent,
    LandingpageComponent,
    ChatInformationComponent,
    ChatConversationComponent,
    RegisterComponent,
    HeaderComponent,
    UserProfileComponent
  ],
  // de pus modulele aici
  imports: [
    AuthModule.forRoot({
      config: [
        {
          configId: 'frontend',
          authority: environment.authUrl,
          redirectUrl: window.location.origin,
          postLogoutRedirectUri: window.location.origin,
          clientId: 'zkybe.web',
          scope: 'openid zkybe.users zkybe.admin',
          responseType: 'code',
          disablePkce: false,
          logLevel: environment.production==true ? LogLevel.None : LogLevel.Debug,
        }
      ]
    }),
    MatSnackBarModule,
    BrowserAnimationsModule,
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
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
