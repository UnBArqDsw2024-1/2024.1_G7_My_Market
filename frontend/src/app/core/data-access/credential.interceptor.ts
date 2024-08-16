import { HttpInterceptorFn } from '@angular/common/http';

export const credentialInterceptor: HttpInterceptorFn = (request, next) => {
  const modifiedRequest = request.clone({
    withCredentials: true
  });
  return next(modifiedRequest);
};