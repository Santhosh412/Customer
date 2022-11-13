package com.springcsvfile.csvfile.helper;

import com.springcsvfile.csvfile.model.Tutorial;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
	public static String TYPE = "application/vnd.ms-excel";

	static String[] HEADERs = { "Reference date", "Annotator", "Index", "Action", "Internal Index",
			"Co-occurring Rule ID", "Biomarker type", "Variant/Rule", "sequence/structural", "Transcript ID" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Tutorial> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			List<String> headerNames = csvParser.getHeaderNames();
			int count = 0;
			for (String string : headerNames) {
				if (HEADERs[count].equalsIgnoreCase(string)) {
					count = count + 1;
				} else {
					throw new RuntimeException(string + " header is mismatch with this " + HEADERs[count]);
				}
			}
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				if (csvRecord.get(8).equalsIgnoreCase("structural")
						|| csvRecord.get(8).equalsIgnoreCase("sequence") && csvRecord.get(9).equalsIgnoreCase("")
						|| csvRecord.get(9).startsWith("NM_")) {
					Tutorial tutorial = new Tutorial(Long.parseLong(csvRecord.get(0)),

							csvRecord.get(1), csvRecord.get(2), csvRecord.get(3), csvRecord.get(4),
							Integer.parseInt(csvRecord.get(5)), csvRecord.get(6), csvRecord.get(7), csvRecord.get(8),
							csvRecord.get(9));
					System.out.println("tutotial" + tutorial);
					tutorials.add(tutorial);
					//
				}

				else {
					throw new RuntimeException(
							"headerRecordValue for the column  should be sequence/structural for row number="
									+ csvRecord.getRecordNumber() + "   actual value= " + csvRecord.get(8)
									+ "   PLease check 9th record also it would start with NM_ and actural is "
									+ csvRecord.get(9));
				}
			}
			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream tutorialsToCSV(List<Tutorial> tutorials) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (Tutorial tutorial : tutorials) {
				List<String> data = Arrays.asList(String.valueOf(tutorial.getReferenceDate()), tutorial.getAnnotator(),
						tutorial.getIndex(), tutorial.getAction(), tutorial.getInternalIndex(),
						tutorial.getBioMarkerType(), tutorial.getVariantOrRule(), tutorial.getSequenceOrStructural(),
						tutorial.getTranscriptID(), String.valueOf(tutorial.getCoOccurringRuleID()));

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}

	}

}
