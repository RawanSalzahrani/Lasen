package lasen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

import java.net.MalformedURLException;


public class CMUSphinx {
	//Configuration configuration = new Configuration();
    private StreamSpeechRecognizer recognizer;
   
	public String getHypotesis(String fileName) throws IOException{
		
		if (this.recognizer == null)
                {
	            // First start
		    try 
                    {  
                        this.recognizer = new StreamSpeechRecognizer(createConfiguration());
                    }
                    catch (IOException e) 
                    { 
                        throw new IllegalStateException("Error initializing ", e); 
                    }
		}
                
		this.recognizer.startRecognition(new FileInputStream(fileName));
			
		SpeechResult result = recognizer.getResult();
		if (result != null) 
                {
		    recognizer.stopRecognition();
		    
                    String phonem = result.getResult().getBestPronunciationResult().toString();
                    phonem = phonem.replaceAll(",", " ").substring(phonem.indexOf("[")+1, phonem.indexOf("]")); 
                    return phonem;
                    
                }
			
		recognizer.stopRecognition();
			
		return "Know";
		
	}
        private Configuration createConfiguration() throws FileNotFoundException, MalformedURLException {
		
            Configuration configuration = new Configuration();

	    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("4984.dic");
            configuration.setLanguageModelPath("4984.lm");
            
          	
            return configuration;
	}
	
}
