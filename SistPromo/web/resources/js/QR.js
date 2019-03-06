const wifi = {
  ssid: 'ssid',
  pass: 'password',
  type: 'WPA',
  hidden: false
};

const qrImg = document.getElementById('qr');
const ssid = document.getElementById('ssid');
const pass = document.getElementById('pass');
const hidden = document.getElementById('hidden');
const update = document.getElementById('update');
update.addEventListener('click', updatePrint);

function tOnly (bool) {
  return bool ? true : '';
}

function updatePrint () {
  updateInfo();
  setTimeout(() => window.print(), 750);
}

function updateInfo () {
  wifi.ssid = ssid.value;
  wifi.pass = pass.value;
  wifi.hidden = hidden.checked;
  let qrUrl = `https://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=${encodeURIComponent(`WIFI:S:${wifi.ssid};T:${wifi.type};P:${wifi.pass};${tOnly(wifi.hidden)};`)}`;
  qrImg.src = qrUrl;
}
