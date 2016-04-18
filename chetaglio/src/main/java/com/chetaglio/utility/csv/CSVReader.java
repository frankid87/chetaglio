package com.chetaglio.utility.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {
	
	private static CSVParser csvParser;
	private static CSVFormat csvFileFormat;
	
	public static List<CSVRecord> parser(InputStream inputStream, String[] FILE_HEADER_MAPPING) throws IOException{
		csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		InputStreamReader reader = new InputStreamReader(inputStream);
		csvParser = new CSVParser(reader, csvFileFormat);
		return csvParser.getRecords();
	}
	
}
