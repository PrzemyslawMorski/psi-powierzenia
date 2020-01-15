import { element, by, ElementFinder } from 'protractor';

export default class EntrustmentPlanUpdatePage {
  pageTitle: ElementFinder = element(by.id('powierzeniaApp.entrustmentPlan.home.createOrEditLabel'));
  saveButton: ElementFinder = element(by.id('save-entity'));
  cancelButton: ElementFinder = element(by.id('cancel-save'));
  academicYearInput: ElementFinder = element(by.css('input#entrustment-plan-academicYear'));
  semesterTypeSelect: ElementFinder = element(by.css('select#entrustment-plan-semesterType'));
  entrustmentsSelect: ElementFinder = element(by.css('select#entrustment-plan-entrustments'));

  getPageTitle() {
    return this.pageTitle;
  }

  async setAcademicYearInput(academicYear) {
    await this.academicYearInput.sendKeys(academicYear);
  }

  async getAcademicYearInput() {
    return this.academicYearInput.getAttribute('value');
  }

  async setSemesterTypeSelect(semesterType) {
    await this.semesterTypeSelect.sendKeys(semesterType);
  }

  async getSemesterTypeSelect() {
    return this.semesterTypeSelect.element(by.css('option:checked')).getText();
  }

  async semesterTypeSelectLastOption() {
    await this.semesterTypeSelect
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
