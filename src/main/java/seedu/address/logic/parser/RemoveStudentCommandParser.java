package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.RemoveCommand;
import seedu.address.logic.commands.RemoveStudentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.TempClass;

public class RemoveStudentCommandParser implements Parser<RemoveCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the
     * DeleteCommand
     * and returns a DeleteCommand object for execution.
     * 
     * @throws ParseException if the user input does not conform the expected format
     */
    public RemoveStudentCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_CLASS);

        // ensures that student name and class name is provided
        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_CLASS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemoveCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_CLASS);
        Name studentName = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
//        TempClass studentClass = ParserUtil.parseClass(argMultimap.getValue(PREFIX_CLASS).get());
        TempClass studentClassPlaceholder = new TempClass();
        return new RemoveStudentCommand(studentName, studentClassPlaceholder);

    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
