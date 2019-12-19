// Empty constructor
function EntelFingerPlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
EntelFingerPlugin.prototype.getwsq = function(successCallback, errorCallback) {
  var options = {};
  cordova.exec(successCallback, errorCallback, 'EntelFingerPlugin', 'getwsq', [options]);
}

// Installation constructor that binds EntelFingerPlugin to window
EntelFingerPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.entelFingerPlugin = new EntelFingerPlugin();
  return window.plugins.entelFingerPlugin;
};
cordova.addConstructor(EntelFingerPlugin.install);