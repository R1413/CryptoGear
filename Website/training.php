<?php

/*
 * Vivo Applications
 *
 * PHP for the training page.
 */

include("global.php");
ensure_logged_in();

$description = "Hone your cryptography skills to become the very best!";
$keywords = "crypto, vivo, applications, training";
$cssfiles = ["styles/global.css", "styles/training.css"];
$jsfiles = ["scripts/global.js", "scripts/training.js"];
printHeader("Training | Crypto", $description, $keywords, $cssfiles, $jsfiles);
printNavbar();
?>

<div id="main_content">
    <h1>Training</h1>
    <p> Welcome to your training. We'll take you through the basics. By the end, you'll learn all you need to know about analyzing encrypted text, or "cryptanalysis." Cryptanalysis is the study of breaking encrypted texts, usually to gain access to hidden information. Understanding how to analyze "ciphertexts" (or "cyphertexts") can be a valuable tool in cracking passwords and understanding the algorithms the safekeepers use behind the scenes. Each level gets progressively harder. After you read through each level, there will be a section that ends with a pop quiz, so you can test your knowledge of each cipher. </p>
    <br>
    <br>
		<p1>Level 1:<br>The Atbash Cipher</p1>
			<p> Atbash Cipher is a type of substitution cipher. What's a substitution cipher? It's a cipher where each letter is substituted for another one in some fashion. The Atbash cipher works by mapping the letters of a plaintext to the opposite side of the alphabet. 'z' maps to 'a'. 'c' maps to 'x'. If the given string is 'xyz', the ciphertext will be 'cba'. By reversing the letters of the alphabet in this way, Atbash can convert a text into a secret message. In decoding messages, (a.k.a in performing cryptanalysis) Atbash is one that is definitely guessed at first, since the algorithm is simple: you reverse all the letters in the alphabet, write them below the original alphabet and there you have your mapping.</p>
			
			<br>
			<p>

			<p2>Atbash Cipher Pop Quiz</p2>
			<p>
				<head>
				<script>
				function wrong()
				{
				alert("Incorrect! Try Again!");
			}
			</script>
	
				<script>
				function right()
				{
				alert("Correct!");
			}
			</script>
		</head>
	</p>
			<body>
            <p3> What type of cipher is the Atbash Cipher?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> It's a substitution cipher.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It's a transposition cipher.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It's a transfer cipher.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It's some other cipher...</button> 
		</body>
	</p>
	        <br>
			<body>
            <p3>How does the Atbash Cipher work?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It transposes letters using the alphabet.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> It reverses the letters across the alphabet.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It shifts letters across the alphabet.</button> 
		</body>
	</p>
	
	<br>
	
	<p1>Level 2:<br>The Caesar Cipher</p1>
			<p> Pretty effortless, huh? The Caesar cipher is just as easy. It's a cipher which takes a "key" and it shifts each letter in the plaintext, across the alphabet, by the amount of our key. For example, if you have a plaintext "hi", and the key is 2, the ciphertext will be "jk". If you have a message, "Cryptography rocks", and a key of 4, then it will turn into "Gvctxskvetlc vsgow!" 
<br>
    Messages start to look ugly, but can you spot a weakness behind this kind of cipher? 
<br>
    Someone sends you a text message and it's encrypted. Since you just learned about caesar ciphers, you guess that it might be a caesar-cipher text. You write down the text message, and you remember your alphabet (hopefully!). You begin shifting the letters across the alphabet, all by 1, and you look to see if the message makes sense. You try shifts of 1, 2, 3, 4 and when you reach a shift of 25, you finally find that the encrypted message says, "Hopefully this doesn't take you a long time to decrypt!". You get angry.
<br>

    Working on caesar shifts in sequential order takes too much time. Surely, there must be a faster way. We could stop working on a caesar shift when the word stops making sense, that seems like a good idea. Or maybe we could find the words that are three letters long, guess those first, and then use that guess for the rest of the message. Seems like knowing the "structure" of the English language would really help. In decoding a message, we can use a method called "frequency analysis." What's frequency analysis? It just means we count how often each letter of the alphabet appears in our text. We compare, or "analyze", our result with a helpful reference point: the frequency of letters in the English language. 
    <br> 
    Here are those frequencies ranked (E is by far the most common!): E, T, A, O, I, N, S, R, H, L, D, C, U, M, F, P, G, W, Y, B, V, K, X, J, Q, Z.
    <br>
    Okay, so let's do it. We first analyze the ciphertext and figure out the characters that appear the most times (the first few popular letters is good enough, most of the time). Then, we try to shift the letters of our ciphertext by guessing a key that makes the ciphertext frequencies match as close as we can, if we can't match exactly, the frequencies of letters in the English alphabet. Using this, we are pretty much dead-on if the sentence is long enough (the longer the sentence, the closer it conforms to being a regular, old-fashioned english sentence). Even for short messages, we are spot on most of the time (what does this say about the English language?). So the caesar shifts don't hinder our cryptanalysis skills. A shift of 1 doesn't do much if we can find the most common letter in that message ('F') and compare it to our list of ranked frequencies and find our extremely good guess based on the frequencies of the entire English language (a.k.a. 'E').</p>

	<p2>Caesar Cipher Pop Quiz</p2>
		<p> </p>
			<body>
            <p3>How do you perform frequency analysis for a Caesar cipher?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()">Find the least frequent letters.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()">Find all letters that are vowels.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()">Pick any letter you want.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> Find the most frequent letters.</button> 
		</body>
        </p>
	        <br>
			<body>
            <p3>Given the plaintext, "soccer", and a key of 5, what should the letter c be in the ciphertext?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()">k </button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> g  </button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> h </button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> q </button> 
		</body>
	</p>

        <br>

		<p1>Level 3:<br>The Affine Cipher</p1>
			<p> Here's a more sophisticated cipher. It's also a substitution cipher, but the Affine cipher requires an input of two keys instead of just one. Not only that, but these two have to be coprime to each other. Coprime? That means they are relatively prime to each other. '4' and '11' are coprime, and '5' and '14' are as well. Yes, they can be even numbers, as long as the other number doesn't share a greatest common divisor greater than 1 (two even numbers would share a greatest common divisor (GCD) of 2). So as long as the GCD of our two keys don't exceed 1, we are good. 
    <br>
    The equation used to create an Affine cipher is this one: c = ap+b(mod m).
    <br>
     What now? 'a' and 'b' are our coprime keys (usually called our 'alpha' and 'beta'). 'm' is the size of our alphabet, which should be 26, unless we're feeling crazy and add some new characters to our alphabet. It's whatever. Now 'p' represents each letter's position in the alphabet, it's our letter's index ('a' would have a p of 0, p = 1 for 'b', the p for 'z' is 25). So if we were to use keys of 5 and 7, and an 'm' of 26, and our message was "hi", then the p for the letter 'h' would be 7, and p for the letter 'i' would be 8, and to encrypt 'h', we would plug in all the given information into our fancy equation:
    <br>
    c = 5*7+7 (mod 26) =  16
    <br>
      The letter at index 16 in the alphabet (the 17th letter in the alphabet) is 'q' so our 'h' will be encrypted to 'q'. 
      <br>
      Now, if we find an encrypted message and we think it's an Affine Cipher, then we might require information about the keys, however, most of the time, by performing our frequency analysis, we can make pretty good guesses of the two most common characters in the ciphertext. Analyzing in this way, we can backtrack and find the keys. 
      <br>
			Steps for Cryptanalysis of an Affine Cipher: </p>

			<p> 1. Find the two most common characters in the ciphertext. Say they are 'h' and 'q'. You can assume that these ciphered characters correspond to 'e' and 't' in the plaintext (remember our list of ranked frequencies!). </p>
			<p> 2. Plug this into our equation! With 'e' = 4, 't' = 19, 'h' = 7, and 'q' = 16, we have a*4+b = 7 and a*19+b = 16. </p>
			<p> 3. Okay here is another equation!
    			<br>
    			 a*p+b = c1 and a*q+b = c2
    			 <br>
    			 The c's are the two ciphered characters we guessed. </p>
			<p> 4. Now here are some more equations! The equations to solve for our two unknown keys are: a = D^-1 (c1-c2) mod 26 and b = D^-1(pc2-qc1) mod 26.  </p>
			<p> 5. Now, we have to find the inverse of D. Here's how to do that in our case: 
    			<br>
    			D = p-q = 4-19 = -15 = 11 mod 26 => D^-1 = 19.  
    			<br>
    			</p>
			<p> 6. Okay. Finally, we plug everything in, and we have:
    			<br>
    			a = 19* (c1-c2) mod 26 = 19 * -9 mod 26 = 11
    			<br> 
    			b = 19*(pc2-qc1) mod 26 = 19*(64-133) mod 26 = 15
    			<br>
    			So the keys behind our cipher are 11 and 15! </p>
    			
			<p> 7. After figuring out all of the keys, you can use them to back track! You just this other equation: p = a^-1(c-b) mod m.  </p>
			
			<p4> (Source: http://practicalcryptography.com/ciphers/classical-era/affine/)</p4>
			
			<br>
			<br>
			<br>
			
		<p2> Affine Cipher Pop Quiz</p2>
		<p> </p>
			<body>
            <p3>What are the requirements of the input keys of an Affine cipher?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> It requires that the keys are not prime compared to 'm'.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> They have to be positive numbers.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> They have to be relatively prime to 'm'.</button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> There aren't any.</button> 
		</body>
	</p>
			<body>
            <p3>What is the equation used to encrypt a message as an Affine cipher?</p3>
            <br>
            <br>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()">c=a+b mod m </button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="right()"> c=ap+b(mod m)  </button>
			<button type="button" id="pop_quiz_button" style ="width:100px;height:80px;"
			onclick="wrong()"> c=a+b </button> 
		</body>
	</p>
</div>

<?= printFooter() ?>