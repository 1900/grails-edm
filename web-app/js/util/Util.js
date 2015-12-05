var util = {
    getUrlParameter: function(param) {
        return decodeURIComponent((new RegExp('[?|&]' + param + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null
    },
    
    validateEmail: function(email) { 
        var reg = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return reg.test(email);
    },
    
    validateMobileNumber: function(mobileNo) {
        var reg = /^0*(13|15)\d{9}$/; 
        return reg.test(mobileNo);
    },
    
    validatePhoneNumber: function(phoneNo) {
        var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/
        return reg.test(phoneNo);
    },
    
    validatePhoneOrMobileNumber: function(phoneOrMobileNumber) {
        var reg = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/
        return reg.test(phoneOrMobileNumber);
    },
    
    getPlatformString: function() {
        if(navigator.platform.indexOf("android") != -1) {
            return "android"
        }
        
        if(navigator.platform.indexOf("iPhone") != -1) {
            return "iPhone"
        }
        
        return "other"
    }
};