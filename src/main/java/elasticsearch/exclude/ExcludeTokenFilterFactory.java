package org.elasticsearch.index.analysis.exclude;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.miscellaneous.UniqueTokenFilter;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class ExcludeTokenFilterFactory extends AbstractTokenFilterFactory {

    private final boolean onlyOnSamePosition;

    public ExcludeTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        this.onlyOnSamePosition = settings.getAsBoolean("only_on_same_position", false);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new ExcludeTokenFilter(tokenStream, onlyOnSamePosition);
    }
}
