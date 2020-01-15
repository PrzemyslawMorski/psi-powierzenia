import { element, by, ElementFinder } from 'protractor';

export default class CourseUpdatePage {
  pageTitle: ElementFinder = element(by.id('powierzeniaApp.course.home.createOrEditLabel'));
  saveButton: ElementFinder = element(by.id('save-entity'));
  cancelButton: ElementFinder = element(by.id('cancel-save'));
  nameInput: ElementFinder = element(by.css('input#course-name'));
  codeInput: ElementFinder = element(by.css('input#course-code'));
  classesSelect: ElementFinder = element(by.css('select#course-classes'));
  tagsSelect: ElementFinder = element(by.css('select#course-tags'));

  getPageTitle() {
    return this.pageTitle;
  }

  async setNameInput(name) {
    await this.nameInput.sendKeys(name);
  }

  async getNameInput() {
    return this.nameInput.getAttribute('value');
  }

  async setCodeInput(code) {
    await this.codeInput.sendKeys(code);
  }

  async getCodeInput() {
    return this.codeInput.getAttribute('value');
  }

  async classesSelectLastOption() {
    await this.classesSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async classesSelectOption(option) {
    await this.classesSelect.sendKeys(option);
  }

  getClassesSelect() {
    return this.classesSelect;
  }

  async getClassesSelectedOption() {
    return this.classesSelect.element(by.css('option:checked')).getText();
  }

  async tagsSelectLastOption() {
    await this.tagsSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async tagsSelectOption(option) {
    await this.tagsSelect.sendKeys(option);
  }

  getTagsSelect() {
    return this.tagsSelect;
  }

  async getTagsSelectedOption() {
    return this.tagsSelect.element(by.css('option:checked')).getText();
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
