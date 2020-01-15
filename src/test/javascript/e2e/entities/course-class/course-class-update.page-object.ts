import { element, by, ElementFinder } from 'protractor';

export default class CourseClassUpdatePage {
  pageTitle: ElementFinder = element(by.id('powierzeniaApp.courseClass.home.createOrEditLabel'));
  saveButton: ElementFinder = element(by.id('save-entity'));
  cancelButton: ElementFinder = element(by.id('cancel-save'));
  hoursInput: ElementFinder = element(by.css('input#course-class-hours'));
  formSelect: ElementFinder = element(by.css('select#course-class-form'));
  entrustmentsSelect: ElementFinder = element(by.css('select#course-class-entrustments'));

  getPageTitle() {
    return this.pageTitle;
  }

  async setHoursInput(hours) {
    await this.hoursInput.sendKeys(hours);
  }

  async getHoursInput() {
    return this.hoursInput.getAttribute('value');
  }

  async setFormSelect(form) {
    await this.formSelect.sendKeys(form);
  }

  async getFormSelect() {
    return this.formSelect.element(by.css('option:checked')).getText();
  }

  async formSelectLastOption() {
    await this.formSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }
  async entrustmentsSelectLastOption() {
    await this.entrustmentsSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async entrustmentsSelectOption(option) {
    await this.entrustmentsSelect.sendKeys(option);
  }

  getEntrustmentsSelect() {
    return this.entrustmentsSelect;
  }

  async getEntrustmentsSelectedOption() {
    return this.entrustmentsSelect.element(by.css('option:checked')).getText();
  }

  async save() {
    await this.saveButton.click();
  }

  async cancel() {
    await this.cancelButton.click();
  }

  getSaveButton() {
    return this.saveButton;
  }
}
