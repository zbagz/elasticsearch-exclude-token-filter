package elasticsearch.exclude;

import java.util.Collection;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;

public class ExcludePlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "ExcludePlugin";
    }

    @Override
    public String description() {
        return "Plugin that provides a Token Filter that excludes tokens based on occurrences / frequency.";
    }
}
