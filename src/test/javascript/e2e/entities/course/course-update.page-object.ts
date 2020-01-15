import { element, by, ElementFinder } from 'protractor';

export default class CourseUpdatePage {
  pageTitle: ElementFinder = element(by.id('powierzeniaApp.course.home.createOrEditLabel'));
  saveButton: ElementFinder = element(by.id('save-entity'));
  cancelButton: ElementFinder = element(by.id('cancel-save'));
  nameInput: ElementFinder = element(by.css('input#course-name'));
  codeInput: ElementFinder = element(by.css('input#course-code'));
  educationPlanSelect: ElementFinder = element(by.css('select#course-educationPlan'));
  teacherSelect: ElementFinder = element(by.css('select#course-teacher'));

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

  async educationPlanSelectLastOption() {
    await this.educationPlanSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async educationPlanSelectOption(option) {
    await this.educationPlanSelect.sendKeys(option);
  }

  getEducationPlanSelect() {
    return this.educationPlanSelect;
  }

  async getEducationPlanSelectedOption() {
    return this.educationPlanSelect.element(by.css('option:checked')).getText();
  }

  async teacherSelectLastOption() {
    await this.teacherSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async teacherSelectOption(option) {
    await this.teacherSelect.sendKeys(option);
  }

  getTeacherSelect() {
    return this.teacherSelect;
  }

  async getTeacherSelectedOption() {
    return this.teacherSelect.element(by.css('option:checked')).getText();
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
