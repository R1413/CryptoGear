function AffineCipher() {
        
        
    //$("output").innerHTML = $("encrypt").value;
    var string = $("encrypt").value;
    //string = string.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g,"");
    //string = string.replace(/\s{2,}/g," ");
        
    //$("output").innerHTML = string;
        
    //alpha and beta are coprime
    var alpha = 9;
    var beta = 13;

    var alphanum = { "a":0, "b":1, "c":2, "d":3, "e":4, "f":5, "g":6, "h":7, "i":8, "j":9, "k":10, "l":11, "m":12, "n":13, "o":14, "p":15, "q":16, "r":17, "s":18, "t":19, "u":20, "v":21, "w":22, "x":23, "y":24, "z":25 };
        
    len = string.length;
    var cipher = "";
    for (var i = 0; i < len; i++) {
        index = (alpha*(alphanum[string[i]]) + beta) % 26;
        var found = false;
        for(var key in alphanum) {
            if(alphanum[key] === index) {
                cipher += key;
                found = true;
            }
        }
        if (!found) {
            cipher += string[i];
        }

    }

    //$("output").innerHTML = cipher;
    return cipher;

}
   
   

var CaesarCipherEncrypt = function(string, key) 
{
    var ciphertext = "";
    for(var i = 0; i < string.length; i++) 
    {
        var character_code = string.charCodeAt(i);
        if(character_code >= 97 && character_code <= 122) 
        {
            ciphertext += String.fromCharCode((character_code - 97 + key) % 26 + 97);
        } 
        else if(character_code >= 65 && character_code <= 90) 
        {
            ciphertext += String.fromCharCode((character_code - 65 + key) % 26 + 65);
        } else 
        {
            ciphertext += String.fromCharCode(character_code);
        }
    }
    return ciphertext;
}

var CaesarCipherDecrypt = function(string, key) 
{
    var plaintext = "";
    for(var i = 0; i < string.length; i++) 
    {
        var character_code = string.charCodeAt(i);
        if(character_code >= 97 && character_code <= 122) 
        {
            plaintext += String.fromCharCode((character_code - 97 - key + 26) % 26 + 97);
        } 
        else if(character_code >= 65 && character_code <= 90) 
        {
            plaintext += String.fromCharCode((character_code - 65 - key + 26) % 26 + 65);
        } else 
        {
            plaintext += String.fromCharCode(character_code);
        }
    }
    return plaintext;
}
    


function AtbashCipher(string)
{
	var normal_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	var atbash_alphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
	var return_string = '';
	for(i =0; i < string.length; i++)
	{
		var character_encode = string.charAt(i);
		var character_index = normal_alphabet.indexOf(character_encode);
		var character_decode = atbash_alphabet.charAt(character_index);
		return_string += character_decode;
	}
	return return_string;
}



/* Functions pulled from http://practicalcryptography.com/ciphers/classical-era/rail-fence/  */
function railsFenceEncrypt(string,key)
{
	plaintext = string.toLowerCase().replace(/[^a-z]/g, "");
	ciphertext = "";
	for(line=0; line<key-1; line++){
    	skip=2*(key-line-1);
    	j=0;
        for(i=line; i<plaintext.length;){
            ciphertext += plaintext.charAt(i);
       	    if((line==0) || (j%2 == 0))	i+=skip;
       	     else i+=2*(key-1) - skip; 
        	 j++; 
        	
        }
    }
    for(i=line; i<plaintext.length; i+=2*(key-1)) ciphertext += plaintext.charAt(i);
    return ciphertext;
}

function railsFenceDecrypt(string, key)
{
	ciphertext = string.toLowerCase().replace(/[^a-z]/g, "");  
	pt = new Array(ciphertext.length);   k=0;
	for(line=0; line<key-1; line++){
		skip=2*(key-line-1);	 j=0;
    	for(i=line; i<ciphertext.length;){
    	    pt[i] = ciphertext.charAt(k++);
   	    	if((line==0) || (j%2 == 0)) i+=skip;
    		  else i+=2*(key-1) - skip;  
    		  j++; 
    	}       
    }

	for(i=line; i<ciphertext.length; i+=2*(key-1)) pt[i] = ciphertext.charAt(k++);
	return pt.join("");
}
    
    
    
function Letters_Frequency(string) 
{
    var frequency = {};
    for (var i=0; i<string.length;i++) 
    {
        var character = string.charAt(i);
        if (frequency[character]) 
        {
           frequency[character]++;
        } 
        else
        {
           frequency[character] = 1;
        }
    }

    return frequency;

};

    

