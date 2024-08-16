import { bootstrapApplication, BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { importProvidersFrom } from '@angular/core';
import { provideHttpClient, withFetch, withInterceptors, withInterceptorsFromDi } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideRouter } from '@angular/router';
import { APP_ROUTES } from './app/app.routes';
import { credentialInterceptor } from './app/core/data-access/credential.interceptor';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

bootstrapApplication(AppComponent, {
  providers: [
      importProvidersFrom(BrowserModule),
      provideHttpClient(withFetch(), withInterceptors([credentialInterceptor])),
      provideAnimations(),
      provideHttpClient(withInterceptorsFromDi()),
      provideRouter(APP_ROUTES), provideAnimationsAsync()
  ]
})
  .catch(err => console.error(err));