import { Injectable } from '@angular/core';
import { UntypedFormArray, UntypedFormControl, UntypedFormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormUtilsService {

  constructor() { }

  validateAllFormFields(formGroup: UntypedFormGroup | UntypedFormArray) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof UntypedFormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof UntypedFormGroup || control instanceof UntypedFormArray) {
        control.markAsTouched({ onlySelf: true });
        this.validateAllFormFields(control);
      }
    });
  }

  getErrorMessage(formGroup: UntypedFormGroup, fieldName: string) {
    const field = formGroup.get(fieldName) as UntypedFormControl;
    return this.getErrorMessageFromField(field);
  }

  getErrorMessageFromField(field: UntypedFormControl): string {
    if (field?.hasError('required')) {
      return 'Campo obrigatório.';
    }

    if (field?.hasError('maxlength') && field.errors) {
      const requiredLength = field.errors['maxlength']['requiredLength'];
      return `Campo não pode ser maior que ${requiredLength} caracteres.`;
    }

    if (field?.hasError('minlength') && field.errors) {
      const requiredLength = field.errors['minlength']['requiredLength'];
      return `Campo não pode ser menor que ${requiredLength} caracteres.`;
    }

    if (field?.hasError('min') && field.errors) {
      const requiredValue = field.errors['min']['min'];
      return 'Valor mínimo é ' + requiredValue;
    }

    if (field?.hasError('max') && field.errors) {
      const requiredValue = field.errors['max']['max'];
      return 'Valor máximo é ' + requiredValue;
    }

    return field['errors'] ? 'Error' : '';
  }
}
