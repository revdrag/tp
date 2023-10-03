package seedu.address.model.module;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

import static java.util.Objects.requireNonNull;

public class Class {
    private final ClassName className;

    public Class(ClassName className) {
        requireNonNull(className);
        this.className = className;
    }

    public ClassName getClassName() {
        return className;
    }

    public boolean isSameClass(Class otherClass) {
        if (otherClass == this) {
            return true;
        }

        return otherClass != null
                && otherClass.getClassName().equals(getClassName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Class)) {
            return false;
        }

        Class otherClass = (Class) other;
        return className.equals(otherClass.className);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(className);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("class name", className)
                .toString();
    }

}
