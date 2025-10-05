function setLoginState(state) {
  const panel = document.querySelector('.login-panel');
  panel.classList.remove('error', 'success', 'animated');

  if (state === 'error') {
    panel.classList.add('error');
    setTimeout(() => {
      panel.classList.remove('error');
      panel.classList.add('animated'); // volta para o padrão
    }, 1000);
  } else if (state === 'success') {
    panel.classList.add('success');
  } else {
    panel.classList.add('animated');
  }
}