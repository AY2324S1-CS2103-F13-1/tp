package connexion.logic.parser;


import static connexion.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static connexion.logic.parser.CliSyntax.PREFIX_COMPANY;
import static connexion.logic.parser.CliSyntax.PREFIX_EMAIL;
import static connexion.logic.parser.CliSyntax.PREFIX_JOB;
import static connexion.logic.parser.CliSyntax.PREFIX_NAME;
import static connexion.logic.parser.CliSyntax.PREFIX_PHONE;
import static connexion.logic.parser.CliSyntax.PREFIX_TAG;
import static java.util.Objects.requireNonNull;

import java.util.Arrays;

import connexion.logic.commands.FilterCommand;
import connexion.logic.parser.exceptions.ParseException;
import connexion.model.person.CompanyContainsKeywordsPredicate;
import connexion.model.person.EmailContainsKeywordsPredicate;
import connexion.model.person.JobContainsKeywordsPredicate;
import connexion.model.person.NameContainsKeywordsPredicate;
import connexion.model.person.PhoneContainsKeywordsPredicate;
import connexion.model.tag.TagContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FilterCommand object.
 */
public class FilterCommandParser implements Parser<FilterCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterCommand
     * and returns a FilterCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        String prefix;
        String[] keywords;

        if (trimmedArgs.length() <= 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }

        prefix = trimmedArgs.substring(0, 2);
        keywords = trimmedArgs.substring(2).trim().split("\\s+");

        if (prefix.equals(PREFIX_NAME.getPrefix())) {
            return new FilterCommand(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        if (prefix.equals(PREFIX_PHONE.getPrefix())) {
            return new FilterCommand(new PhoneContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        if (prefix.equals(PREFIX_EMAIL.getPrefix())) {
            return new FilterCommand(new EmailContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        if (prefix.equals(PREFIX_COMPANY.getPrefix())) {
            return new FilterCommand(new CompanyContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        if (prefix.equals(PREFIX_JOB.getPrefix())) {
            return new FilterCommand(new JobContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        if (prefix.equals(PREFIX_TAG.getPrefix())) {
            return new FilterCommand(new TagContainsKeywordsPredicate(Arrays.asList(keywords)));
        }
        // No valid prefix exists, invalid command format
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }
}