import { element, by, ElementFinder } from 'protractor';

export default class EntrustmentUpdatePage {
  pageTitle: ElementFinder = element(by.id('powierzeniaApp.entrustment.home.createOrEditLabel'));
  saveButton: ElementFinder = element(by.id('save-entity'));
  cancelButton: ElementFinder = element(by.id('cancel-save'));
  hoursInput: ElementFinder = element(by.css('input#entrustment-hours'));
  hoursMultiplierInput: ElementFinder = element(by.css('input#entrustment-hoursMultiplier'));

  getPageTitle() {
    return this.pageTitle;
  }

  async setHoursInput(hours) {
    await this.hoursInput.sendKeys(hours);
  }

  async getHoursInput() {
    return this.hoursInput.getAttribute('value');
  }

  async setHoursMultiplierInput(hoursMultiplier) {
    await this.hoursMultiplierInput.sendKeys(hoursMultiplier);
  }

  async getHoursMultiplierInput() {
    return this.hoursMultiplierInput.getAttribute('value');
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
