import { browser, element, by } from 'protractor';

export class MichackathonUiPage {
  navigateTo() {
    return browser.get('/');
  }

  getMainContent() {
    return element(by.css('michackathon-app .main-content'));
  }

  getNavigation() {
    return element(by.css('michackathon-app .navigation'));
  }

  getFooter() {
    return element(by.css('michackathon-app .footer md-card-title'));
  }
}
