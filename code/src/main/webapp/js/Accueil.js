/**
 * 
 */
const homeLink = document.querySelector('#home-link');
const contactLink = document.querySelector('#contact-link');
const accountLink = document.querySelector('#account-link');
const modifyAccountLink = document.querySelector('#modify-account-link');
const consulterLink = document.querySelector('#consulter-link');
const historiqueLink = document.querySelector('#historique-link');

homeLink.addEventListener('click', () => {
  window.location.href = 'acceuil.html';
});

contactLink.addEventListener('click', () => {
  window.location.href = 'contact.html';
});

accountLink.addEventListener('click', () => {
  window.location.href = 'account.html';
});

modifyAccountLink.addEventListener('click', () => {
  window.location.href = 'modify-account.html';
});

consulterLink.addEventListener('click', () => {
  window.location.href = 'test.html';
});

historiqueLink.addEventListener('click', () => {
  window.location.href = 'historique.html';
});